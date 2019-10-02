package com.artemzin.qualitymatters.subscription;

import com.artemzin.qualitymatters.performance.AsyncJob;
import com.artemzin.qualitymatters.performance.AsyncJobsObserver;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class FinishAsyncJobSubscriptionTest {

    @Test
    public void constructor_shouldCreateSuchActionThatWillUnregisterAsyncJob() {
        AsyncJobsObserver asyncJobsObserver = mock(AsyncJobsObserver.class);
        AsyncJob asyncJob = mock(AsyncJob.class);

        DisposableSubscription disposableSubscription = new FinishAsyncJobSubscription(asyncJobsObserver, asyncJob);
        verifyZeroInteractions(asyncJobsObserver, asyncJob);

        disposableSubscription.unsubscribe();
        verify(asyncJobsObserver).asyncJobFinished(asyncJob);
    }
}