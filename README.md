# archunit-demo-kotlin

Demo repository for archunit with Kotlin + freezing feature in archunit

## How to freeze rules

1. write rules

```kotlin
@ArchTest
val `controller should not depends on other controller` =
    // should wrap with `freeze` method to apply the freeze feature to the rule
    FreezingArchRule.freeze(
        classes().that()....
)
```

2. run gradle command

```shell
./gradlew archUnitFreeze
```

This gradle task specify system property in order to store freezing rules. please refer `build.gradle.kts`.

## Class caching

should use `@AnalyzeClasses` annotation to cache class files.

## Q&A

### Can we apply freezing feature all method by easier method?

No. we need to apply freezing feature per method. Thus, the following code snippet is **not** working well:

```kotlin
@ArchTest
// ArchTests != ArchRule. ArchRule.`in` method is deprecated...
val layerCheck = FreezingArchRule.freeze(ArchTests.`in`(ControllerArchTest::class.java))
```
