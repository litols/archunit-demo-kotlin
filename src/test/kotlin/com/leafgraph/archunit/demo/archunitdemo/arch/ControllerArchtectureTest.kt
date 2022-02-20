package com.leafgraph.archunit.demo.archunitdemo

import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.library.freeze.FreezingArchRule
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController


class ControllerArchTest {
    /**
     * Controllerに依存する野蛮なControllerを許さない
     */
    @ArchTest
    val `controller should not depends on other controller` =
        // FreezingArchRuleでwrapしないとfreezeの対象にならない
        FreezingArchRule.freeze(
            classes().that().areAnnotatedWith(RestController::class.java)
                .or().areAnnotatedWith(Controller::class.java)
                .should().onlyHaveDependentClassesThat().areNotAnnotatedWith(RestController::class.java)
        )
}