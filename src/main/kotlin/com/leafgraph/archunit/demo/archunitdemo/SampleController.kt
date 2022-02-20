package com.leafgraph.archunit.demo.archunitdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    val sampleService: SampleService
) {

    @GetMapping("/sample")
    fun sample(): SampleResponse {
        return SampleResponse(
            sample = sampleService.getSample(null)
        )
    }

    @GetMapping("/sample/{parameter}")
    fun sampleWithParameter(
        @PathVariable("parameter") parameter: String
    ): SampleResponse {
        return SampleResponse(
            sample = sampleService.getSample(parameter)
        )
    }
}

data class SampleResponse(
    val sample: String,
)