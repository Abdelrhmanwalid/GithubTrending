package com.abdelrhman.domain.interactor.bookmark

import com.abdelrhman.domain.executor.PostExecutionThread
import com.abdelrhman.domain.interactor.CompletablebleUseCase
import com.abdelrhman.domain.repository.ProjectRepository
import io.reactivex.Completable
import javax.inject.Inject

class UnbookmarkProject @Inject constructor(
    private val projectRepository: ProjectRepository,
    private val postExecutionThread: PostExecutionThread
) : CompletablebleUseCase<UnbookmarkProject.Params>(postExecutionThread) {

    override fun buildUseCaseCompletable(params: UnbookmarkProject.Params?): Completable {
        if (params == null) throw IllegalArgumentException()
        return projectRepository.unbookmarkProject(params.projectId)
    }


    data class Params(val projectId: String) {
        companion object {
            fun forProject(projectId: String) = Params(projectId)
        }
    }
}