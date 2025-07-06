
package com.example.jetsnack

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performScrollToKey
import androidx.compose.ui.test.performTextInput
import com.example.jetsnack.ui.MainActivity
import org.junit.Rule
import org.junit.Test

class UITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun ui_scrollHomePageToNewlyAddedSection() {
        composeTestRule
            .onNodeWithTag("HomeFeed")
            .performScrollToKey("Newly Added")
            .assertExists()

        composeTestRule.onNodeWithTag("NewlyAddedSection").assertIsDisplayed()
    }

    @Test
    fun ui_scrollNewlyAddedSectionHorizontally() {
        composeTestRule
            .onNodeWithTag("HomeFeed")
            .performScrollToKey("Newly Added")

        val row = composeTestRule
            .onNodeWithTag("NewlyAddedRow")
            .assertExists()
            .assertIsDisplayed()


        val itemCount = row.onChildren().fetchSemanticsNodes().size

        row.performScrollToIndex(itemCount - 1)
        row.onChildren().onLast()
            .assertIsDisplayed()


        row.performScrollToIndex(0)
        row.onChildren().onFirst()
            .assertIsDisplayed()
    }


    @Test
    fun ui_navigateToSearchAndFindMango(){
        composeTestRule.onNodeWithContentDescription("SEARCH").performClick()

        val searchField = composeTestRule.onNodeWithTag("SearchInput").assertIsDisplayed()

        searchField.performTextInput("Mango")
        searchField.assertTextEquals("Mango")
    }

    @Test
    fun ui_tapOnSearchResult(){
        composeTestRule.onNodeWithContentDescription("SEARCH").performClick()
        val searchField = composeTestRule.onNodeWithTag("SearchInput").assertIsDisplayed()

        searchField.performTextInput("Mango")
        searchField.assertTextEquals("Mango")

        composeTestRule.waitForIdle()

        composeTestRule
            .onAllNodes(hasText("Mango") and hasSetTextAction().not())
            .onFirst()
            .performClick()

        composeTestRule.onNodeWithText("Details").assertIsDisplayed()
        composeTestRule.onNodeWithText("Lorem ipsum", substring = true).assertIsDisplayed()
    }
}

