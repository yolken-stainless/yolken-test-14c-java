plugins {
    id("yolken-test-14c.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":yolken-test-14c-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :yolken-test-14c-java-example:run` to run `Main`
    // Use `./gradlew :yolken-test-14c-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.configure_me_yolken_test_14c.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
