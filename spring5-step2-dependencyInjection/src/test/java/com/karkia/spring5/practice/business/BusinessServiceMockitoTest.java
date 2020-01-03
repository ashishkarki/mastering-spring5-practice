package com.karkia.spring5.practice.business;

import com.karkia.spring5.practice.beans.Data;
import com.karkia.spring5.practice.beans.User;
import com.karkia.spring5.practice.data.DataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceMockitoTest {
    private static final User DUMMY_USER = new User("dummy");

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private BusinessService businessServiceImpl = new BusinessServiceImpl();

    @Test
    public void testCalculateSumWithMockito() {
        BDDMockito.given(
                dataServiceMock.retrieveData(Matchers.any(User.class))
        ).willReturn(
                Arrays.asList(new Data(10), new Data(15))
        );

        long actualSum = businessServiceImpl.calculateSum(DUMMY_USER);
        assertEquals(25, actualSum);
    }
}
