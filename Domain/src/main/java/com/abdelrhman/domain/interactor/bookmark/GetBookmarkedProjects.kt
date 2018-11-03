package com.abdelrhman.domain.interactor.bookmark

import com.abdelrhman.domain.executor.PostExecutionThread
import com.abdelrhman.domain.interactor.ObservableUseCase
import com.abdelrhman.domain.model.Project
import com.abdelrhman.domain.repository.ProjectRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBookmarkedProjects @Inject constructor(
    private val projectRepository: ProjectRepository,
    private val postExecutionThread: PostExecutionThread) : ObservableUseCase<List<Project>, Nothing>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectRepository.getBookmarkedProjects()
    }
}