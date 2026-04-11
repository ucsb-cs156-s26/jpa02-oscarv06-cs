package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_objects_are_same(){
        Team team2 = new Team("test-team");
        assert(team.equals(team2));
    }

    @Test
    public void equals_objects_are_same_reference(){
        Team team2 = team;
        assert(team.equals(team2));
    }


    @Test
    public void equals_objects_are_different_class(){
        assert(!team.equals("not a team"));
    }

    @Test
    public void equals_objects_are_different_name(){
        Team team2 = new Team("different-name");
        assert(!team.equals(team2));
    }

    @Test
    public void check_hashcode_values(){
        Team team2 = new Team("test-team");
        assert(team.hashCode() == team2.hashCode());
    }

    @Test
    public void hashCode_returns_correct_value() {
        Team t = new Team("test-team");
        int expected = t.name.hashCode() | t.members.hashCode();
        assertEquals(expected, t.hashCode());
    }
   @Test
    public void hashCode_differs_for_different_teams() {
        Team t1 = new Team("team1");
        Team t2 = new Team("team2");
        int expected1 = t1.name.hashCode() | t1.members.hashCode();
        int expected2 = t2.name.hashCode() | t2.members.hashCode();
    
        assertEquals(expected1, t1.hashCode());
        assertEquals(expected2, t2.hashCode());
    }
    
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    
}
