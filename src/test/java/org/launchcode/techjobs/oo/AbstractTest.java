package org.launchcode.techjobs.oo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by LaunchCode
 */
public class AbstractTest {

    public Class getClassByName(String className) throws ClassNotFoundException {
        String basePackage = "org.launchcode.techjobs.oo.";
        // Adjust the package only if className does not already contain the full package name
        if (!className.startsWith(basePackage)) {
            // Check if it's a test class
            if (className.endsWith("Test")) {
                className = "test." + className;
            }
            className = basePackage + className;
        }
        return Class.forName(className);
    }

    private Object initializeJobField(Class clazz, String value) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor constructor = clazz.getConstructor(String.class);
        return constructor.newInstance(value);
    }

    public Job createJob(String name, String employer, String location, String positionType, String coreCompetency) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class jobClass = getClassByName("Job");
        Constructor jobConstructor = jobClass.getConstructor(
                String.class,
                Employer.class,
                Location.class,
                PositionType.class,
                CoreCompetency.class
        );

        return (Job) jobConstructor.newInstance(
                name,
                initializeJobField(Employer.class, employer),
                initializeJobField(Location.class, location),
                initializeJobField(PositionType.class, positionType),
                initializeJobField(CoreCompetency.class, coreCompetency));
    }

    protected String getJobFieldString(Job job, String fieldName, Boolean substituteEmpty) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        String className = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        String getterName = "get" + className;
        Method getter = job.getClass().getMethod(getterName);
        String value;

        if (className.equals("Name")) {
            value = (String) getter.invoke(job);
        } else {
            Class clazz = getClassByName(className);
            Method getValueMethod = clazz.getMethod("getValue");
            value = (String) getValueMethod.invoke(getter.invoke(job));
        }
        if (substituteEmpty && value.equals("")) {
            value = "Data not available";
        }
        return value;
    }

    public String getJobString (Job job) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        return String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n", getJobId(job), getJobFieldString(job, "name", true), getJobFieldString(job, "employer", true), getJobFieldString(job, "location", true),
                getJobFieldString(job, "positionType", true), getJobFieldString(job, "coreCompetency", true));
    }

    protected int getJobId(Job job) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class jobClass = getClassByName("Job");
        Method getIdMethod = jobClass.getMethod("getId");
        return (int) getIdMethod.invoke(job);
    }

}
