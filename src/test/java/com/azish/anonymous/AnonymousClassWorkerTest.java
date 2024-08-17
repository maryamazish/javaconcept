package com.azish.anonymous;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CountDownLatch;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AnonymousClassWorkerTest {

    @Test
    void test(@Mock CountDownLatch countDownLatch) {
        var runnable1 = AnonymousClassWorker.createRunnableWithAnonymousClass(countDownLatch);
        var runnable2 = AnonymousClassWorker.createRunnableWithAnonymousClass2(countDownLatch);
        var runnable3 = AnonymousClassWorker.createRunnableWithoutAnonymousClass(countDownLatch);

        runnable1.run();
        runnable2.run();
        runnable3.run();

        verify(countDownLatch,times(3)).countDown();
        verify(countDownLatch).getCount();
    }
}
