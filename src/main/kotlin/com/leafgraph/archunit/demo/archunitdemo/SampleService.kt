package com.leafgraph.archunit.demo.archunitdemo

import org.springframework.stereotype.Service

@Service
class SampleService {

    fun getSample(parameter: String?): String {
        return parameter ?: "sample"
    }
}