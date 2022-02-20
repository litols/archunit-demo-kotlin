package com.leafgraph.archunit.demo.archunitdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ViolatedController(
    val sampleController: SampleController,
) {
    
    @GetMapping("/violated")
    fun violated(): SampleResponse {
        return sampleController.sample()
    }
}