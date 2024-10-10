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

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void hashCode_equality_same_object(){
        assert(team.equals(team));
    }

    @Test
    public void hashCode_equality_diff_object(){
        int num = 10;
        assert(!team.equals(num));
    }

    @Test
    public void hashCode_is_team(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        assert(t1 instanceof Team);
    }
    
    @Test
    public void hashCode_equal_for_same_team(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    public void hashCode_equal_names_and_members(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assert(t1.name.equals(t2.name) && t1.members.equals(t2.members));
    }

    @Test
    public void diff_teams(){
        Team t1 = new Team();
        t1.setName("foo");
        Team t2 = new Team();
        t2.setName("oof");
        assert(!t1.equals(t2));
    }
    @Test
    public void diff_members(){
        Team t1 = new Team();
        t1.addMember("foo");
        Team t2 = new Team();
        t2.addMember("oof");
        assert(!t1.equals(t2));
    }



    @Test
    public void hashCode_logical_or_corner_case(){
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
