# SampleEspressoProject
Starting state for an Android Studio project with Espresso tests that do instrumented unit tests.

Android Command Line Testing Docs
--
https://developer.android.com/studio/test/command-line.html

Test Command
--
`./gradlew -q connectedAndroidTest`


XML Output
--
XML test result files: `EmptyEspressoProject/app/build/outputs/androidTest-results/connected/`

Configuration Steps
--
Add the following to the app's build.gradle file:
```XML
    androidTestCompile 'com.android.support.test.espresso:espresso-core:2.2.2'
    androidTestCompile 'com.android.support.test.espresso:espresso-intents:2.2.2'
    androidTestCompile 'com.android.support.test:rules:0.5'
    androidTestCompile 'com.android.support.test:runner:0.5'
```

2 Passing Tests, 2 Failing Tests
--
Steps to Pass Included Tests
--
1. Add button to activity_main.xml:
```XML
    <Button
        android:id="@+id/button_share"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        tools:layout_editor_absoluteX="149dp"
        tools:layout_editor_absoluteY="286dp" />
```

2. Add click listener for the button to MainActivity.java:
```java
Button shareButton = (Button) findViewById(R.id.button_share);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareText();
            }
        });
```
3. Implement the shareText() method:
```java
public void shareText() {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "I'm sending some text from an Intent!");

        startActivity(sendIntent);
    }
    ```
