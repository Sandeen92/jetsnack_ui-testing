# Compose UI testing with the Jetsnack sample

This project uses the [Jetsnack sample](https://github.com/android/compose-samples/tree/main/Jetsnack) as a template.
Purpose is to expand testcases and showcase compose UI testing with existing code.

## Further elaboration on the purpose

### What purpose does the test serve? Why are you creating it?

The tests created are meant to replicate interaction by the user and ensure the functionalities work as intended, as well as displaying the correct graphical components to the user.
If any of these functions and components are to be expanded upon, the tests also act as a basis to avoid bugs and errors in development.

### What different test suites are appropriate and what are their responsibilities?

There are a few test types that could be used in this context. Their levels of appropriateness differs.

* **Unit Test** with JUnit - Could target single functions or classes and ensure functions work as intended.
* **Integration Test** with Compose Rule - Interactions with different features
* **End To End Tests** with Espresso or UI Automator - Extensive framework but more suitable for login/onboarding features

### How can you make a structure for future tests for Jetsnack that is sustainable? It should be easy to create new tests.

I would probably structure it in roughly the same categorization as the rest of the project structure. That would unify the structures and ensure full coverage of the code.
Some additions could be made if the development process wants to adapt a more test-driven development, and build a foundation of tests that the developers can utilize when expanding the product.
I'd also emphasize the importance of using testTags and keys when using compose components. This simplifies the creation of testcases as existing libraries can be utilized.
Following naming conventions for consistency and attempting to keep the "testclasses" relatively small is also a keypoint for sustainable and modular structure.
If code, such as navigation to certain pages/fragments/etc, is repeated, consider using a helper-class to avoid flakiness and maintain readable code.

In short, keep the following quality attributes in mind:
* Modularity
* Scalability
* Readability


### How do you deal with flakiness in tests? What countermeasures can we take when creating our test structure?

There are few countermeasures and points to consider and follow in order to avoid flakiness in our test structure.

* Timing-related issues, such as async calls. **Countermeasure =** using waitForIdle() or waitUntil().
* Relying on text, position, or nodes. **Countermeasure =** using explicit selectors such as testTag and keys to name components.
* Tests being independent on the current state. **Countermeasure =** use the @Before tag to clear and reset state before tests.
* UI animation rendering delay. **Countermeasure =** Disable animations in test builds with themes or flags.
* Device-specific or resolution-specific flakiness. **Countermeasure =** Using fake or mock repos in addition to the local repo.

## License

```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[compose]: https://developer.android.com/jetpack/compose
[coil]: https://coil-kt.github.io/coil/
