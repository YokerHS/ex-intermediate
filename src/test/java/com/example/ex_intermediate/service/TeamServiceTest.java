package com.example.ex_intermediate.service;

import com.example.ex_intermediate.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Mock
    private TeamRepository teamRepository;

    @Test
    void testShowList(){

    }

    @Test
    void testShowDetail(){

    }
}


