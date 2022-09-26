package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job test_job;

    @Test
    public void testSettingJobId(){
        Job one = new Job();
        Job two = new Job();
        assertNotEquals(one.getId(), two.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job tester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(tester instanceof Job);
        assertTrue(tester.getEmployer() instanceof Employer);
        assertTrue(tester.getLocation() instanceof Location);
        assertTrue(tester.getPositionType() instanceof PositionType);
        assertTrue(tester.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", tester.getName());
        assertEquals("ACME", tester.getEmployer().getValue());
        assertEquals("Desert", tester.getLocation().getValue());
        assertEquals("Quality control", tester.getPositionType().getValue());
        assertEquals("Persistence", tester.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job thisJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job thatJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(thisJob.equals(thatJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        //this is actually gonna be a formatted version of the job object
        Job thatJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = thatJob.toString();
        assertEquals('\n', jobString.charAt(0));
        assertEquals('\n', jobString.charAt(jobString.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job thatJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String correctString =
                "\n" +
                "ID: " + thatJob.getId() + "\n" +
                "Name: " + thatJob.getName()  + "\n" +
                "Employer: " + thatJob.getEmployer()  + "\n" +
                "Location: " + thatJob.getLocation() + "\n" +
                "Position Type: " + thatJob.getPositionType()  + "\n" +
                "Core Competency: " + thatJob.getCoreCompetency()  + "\n";
        assertEquals(thatJob.toString(), correctString);

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job thisJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(thisJob.toString(), "OOPS! This job does not seem to exist.");

        Job thatJob = new Job("", new Employer("ACME"), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expectedString =
                "\n" +
                        "ID: " + thatJob.getId() + "\n" +
                        "Name: " + "Data not available"  + "\n" +
                        "Employer: " + thatJob.getEmployer()  + "\n" +
                        "Location: " + "Data not available" + "\n" +
                        "Position Type: " + "Data not available"  + "\n" +
                        "Core Competency: " + "Data not available"  + "\n";
        assertEquals(thatJob.toString(), expectedString);

        Job theOtherJob = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String predictedString =
                "\n" +
                        "ID: " + theOtherJob.getId() + "\n" +
                        "Name: " + theOtherJob.getName()  + "\n" +
                        "Employer: " + "Data not available"  + "\n" +
                        "Location: " + "Data not available" + "\n" +
                        "Position Type: " + "Data not available"  + "\n" +
                        "Core Competency: " + "Data not available"  + "\n";
        assertEquals(theOtherJob.toString(), predictedString);

    }
}


