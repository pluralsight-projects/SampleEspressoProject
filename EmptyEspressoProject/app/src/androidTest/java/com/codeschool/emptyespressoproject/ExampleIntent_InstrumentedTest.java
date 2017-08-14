package com.codeschool.emptyespressoproject;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by sarah on 8/14/17.
 */
@RunWith(AndroidJUnit4.class)
public class ExampleIntent_InstrumentedTest {

    private static final String shareMessage = "I'm sending some text from an Intent!";

    @Rule
    public IntentsTestRule<MainActivity> mActivityIntentRule = new IntentsTestRule<>(
            MainActivity.class);

    @Before
    public void stubAllExternalIntents() {
        // By default Espresso Intents does not stub any Intents. Stubbing needs to be setup before
        // every test run. In this case all external Intents will be blocked.
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Test
    public void clickShareButton_SharesText() {
        // Since they may not have created the button we don't know the id so can't use the following:
        //onView(withId(R.id.button_share)).perform(click());
        // Instead find the id:
        int buttonId = mActivityIntentRule.getActivity().getResources().
                getIdentifier("button_share",
                        "id",
                        mActivityIntentRule.getActivity().getPackageName());

        // Only try to click the button if it exists
        if (buttonId != 0) {
            onView(withId(buttonId)).perform(click());

            // intended(Matcher<Intent> matcher) asserts the given matcher matches one and only one
            // intent sent by the application.
            intended(allOf(
                    hasAction(Intent.ACTION_SEND),
                    hasExtra(Intent.EXTRA_TEXT, shareMessage)));
        }
        else {
            Assert.assertEquals(1, 2);
        }
    }
}
