package com.changingfond.mokito;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoTest {

    private class Foo {
        public String someMethod(String foo) {
            return foo;
        }
    }

    @Test
    public void testMockito() {
        LinkedList mockList = mock(LinkedList.class);
        when(mockList.get(0)).thenReturn("first");
        when(mockList.get(1)).thenThrow(new RuntimeException());
        System.out.println(mockList.get(0));
        System.out.println(mockList.get(1));
        System.out.println(mockList.get(2));
        verify(mockList).get(0);

        when(mockList.get(anyInt())).thenReturn("element");
        System.out.println(mockList.get(1));

        mockList.add("once");
        mockList.add("twice");
        mockList.add("twice");
        mockList.add("three times");
        mockList.add("three times");
        mockList.add("three times");
        verify(mockList).add("once");
        verify(mockList, times(1)).add("once");
        verify(mockList, times(2)).add("twice");
        verify(mockList, times(3)).add("three times");
        verify(mockList, never()).add("never add");
        verify(mockList, atLeastOnce()).add("three times");
        verify(mockList, atLeast(2)).add("three times");
        verify(mockList, atMost(5)).add("three times");

        doThrow(new RuntimeException()).when(mockList).clear();
        mockList.clear();

        List singleMock = mock(List.class);
        singleMock.add("was added first");
        singleMock.add("was added second");
        InOrder inOrder = inOrder(singleMock);
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        List firstMock = mock(List.class);
        List secondMock = mock(List.class);
        firstMock.add("was called first");
        secondMock.add("was called second");
        inOrder = inOrder(firstMock, secondMock);
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");

        List oneMock = mock(List.class);
        List twoMock = mock(List.class);
        List threeMock = mock(List.class);
        oneMock.add("one");
        verify(oneMock).add("one");
        verify(oneMock, never()).add("two");
        verifyZeroInteractions(twoMock, threeMock);

        Foo fooMock = mock(Foo.class);
        when(fooMock.someMethod("foo"))
                .thenThrow(new RuntimeException())
                .thenReturn("foo");

        try {
            fooMock.someMethod("foo");
        } catch (Exception e) {

        }
        System.out.println(fooMock.someMethod("foo"));
        System.out.println(fooMock.someMethod("foo"));

        when(fooMock.someMethod("foo"))
                .thenReturn("one", "two", "three");
        System.out.println(fooMock.someMethod("foo"));
        System.out.println(fooMock.someMethod("foo"));
        System.out.println(fooMock.someMethod("foo"));

        // stubing will override previous one
        when(fooMock.someMethod("foo")).thenReturn("four");
        System.out.println(fooMock.someMethod("foo"));

        when(fooMock.someMethod("foo")).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocation) {
                        Object[] args = invocation.getArguments();
                        Object mock = invocation.getMock();
                        return "called with arguments: " + Arrays.toString(args);
                    }
                }
        );
        System.out.println(fooMock.someMethod("foo"));

        doReturn("return").when(fooMock).someMethod("foo");
        System.out.println(fooMock.someMethod("foo"));

    }

}