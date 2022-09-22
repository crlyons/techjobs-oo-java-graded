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
        Job thatJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


        assertEquals();
    }
}
