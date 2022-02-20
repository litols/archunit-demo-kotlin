package com.leafgraph.archunit.demo.archunitdemo

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchTests

/**
 * JUnitの仕組みでcacheしておかないと、追加のたびに実行速度が遅くなるので事実上必須
 */
@AnalyzeClasses(
    packagesOf = [
        ArchunitDemoApplication::class
    ],
    importOptions = [
        ImportOption.DoNotIncludeTests::class,
    ]
)
class ArchUnitBootstrap {

    @ArchTest
    val layerCheck = ArchTests.`in`(ControllerArchTest::class.java)
}