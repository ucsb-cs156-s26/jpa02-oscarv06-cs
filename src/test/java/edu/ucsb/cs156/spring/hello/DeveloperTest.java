package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Oscar V.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("oscarv06-cs", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s26-01", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Oscar V."),"Team should contain Oscar V.");
        assertTrue(t.getMembers().contains("Whisper X."),"Team should contain Whisper X.");
        assertTrue(t.getMembers().contains("Binghao C."),"Team should contain Binghao C.");
        assertTrue(t.getMembers().contains("Shanqin C."),"Team should contain Shanqin C.");
        assertTrue(t.getMembers().contains("Andy W."),"Team should contain Andy W.");
        assertTrue(t.getMembers().contains("Sherwin R."),"Team should contain Sherwin R.");
    }

}
