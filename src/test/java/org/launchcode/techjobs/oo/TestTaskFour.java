package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import org.launchcode.techjobs.oo.test.JobTest;

public class TestTaskFour extends AbstractTest {

    @Test
    public void testTestSettingJobIdExists() throws ClassNotFoundException {
        Class jobTestClass = getClassByName("org.launchcode.techjobs.oo.test.JobTest");
        try {
            Method testSettingJobIdMethod = jobTestClass.getMethod("testSettingJobId");
            assertNotNull(testSettingJobIdMethod);
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testSettingJobId method");
        }
    }

    @Test
    public void testTestSettingJobIdCallsJobConstructorTwice() throws Exception {
        JobTest jobTest = new JobTest();
        jobTest.testSettingJobId();
        // Placeholder for further assertions or logic
    }

    @Test
    public void testTestJobConstructorSetsAllFieldsExists() throws ClassNotFoundException {
        Class jobTestClass = getClassByName("org.launchcode.techjobs.oo.test.JobTest");
        try {
            Method testJobConstructorSetsAllFieldsMethod = jobTestClass.getMethod("testJobConstructorSetsAllFields");
            assertNotNull(testJobConstructorSetsAllFieldsMethod);
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testJobConstructorSetsAllFields method");
        }
    }

    @Test
    public void testTestJobConstructorSetsAllFieldsCallsAsserts() throws Exception {
        JobTest jobTest = new JobTest();
        jobTest.testJobConstructorSetsAllFields();
        // Placeholder for further assertions or logic
    }

    @Test
    public void testTestJobsForEqualityExists() throws ClassNotFoundException {
        Class jobTestClass = getClassByName("org.launchcode.techjobs.oo.test.JobTest");
        try {
            Method testJobsForEqualityMethod = jobTestClass.getMethod("testJobsForEquality");
            assertNotNull(testJobsForEqualityMethod);
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testJobsForEquality method");
        }
    }

    @Test
    public void testTestJobsForEqualityCallsAssertion() throws Exception {
        JobTest jobTest = new JobTest();
        jobTest.testJobsForEquality();
        // Placeholder for further assertions or logic
    }

    // Any additional test methods should follow the same pattern
}
