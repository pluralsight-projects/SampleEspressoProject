package com.codeschool.emptyespressoproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Example_InstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.codeschool.emptyespressoproject", appContext.getPackageName());
    }

    @Test
    public void checkLayoutExists() {
        int layoutId = mActivityRule.getActivity().getResources().
                getIdentifier("activity_main",
                              "layout",
                              mActivityRule.getActivity().getPackageName());

        assertNotEquals(layoutId, 0);
    }

    @Test
    public void checkButtonExists() {
        int buttonId = mActivityRule.getActivity().getResources().
                getIdentifier("button_share",
                        "id",
                        mActivityRule.getActivity().getPackageName());

        assertNotEquals(buttonId, 0);
    }
}
