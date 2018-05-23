package com.oddschecker.bethistory;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;

import com.oddschecker.bethistory.ui.list.MainActivity;
import com.oddschecker.bethistory.utils.AppExecutors;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private final Intent intent = new Intent();
    private AppExecutors appExecutors = new AppExecutors();


    @Rule
    public ActivityTestRule<MainActivity> activityRuleTaskDetails
            = new ActivityTestRule<>(
            MainActivity.class,
            true,     // initialTouchMode
            false);


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.oddschecker.bethistory", appContext.getPackageName());
    }

    @Test
    public void checkNumberOfItemsInRecyclerView() throws InterruptedException {
        //open the activity
        final MainActivity activity = activityRuleTaskDetails.launchActivity(intent);


        //set a countdown to wait for the async job to finishes
        final CountDownLatch latch = new CountDownLatch(1);
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //wait until the screen is populated
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                onView(withId(R.id.recyclerView)).check(matches(withChildViewCount(
                        3, withId(R.id.main_layout))));
                //set countdown to 0, to finish the wait
                latch.countDown();

            }
        });


        //wait 5 seconds to the async job to finish (or until the countdown is set to 0)
        latch.await(10, TimeUnit.SECONDS);
    }

    private static Matcher<View> withChildViewCount(final int count, final Matcher<View> childMatcher) {
        return new BoundedMatcher<View, ViewGroup>(ViewGroup.class) {
            @Override
            protected boolean matchesSafely(ViewGroup group) {
                int matchCount = 0;
                for (int i = 0; i < group.getChildCount(); i++) {
                    if (childMatcher.matches(group.getChildAt(i))) {
                        matchCount++;
                    }
                }
                return matchCount == count;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("RecyclerView with child-count=" + count + " and");
                childMatcher.describeTo(description);
            }
        };
    }
}
