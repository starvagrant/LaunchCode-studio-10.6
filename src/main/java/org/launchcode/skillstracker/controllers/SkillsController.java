package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ResponseBody
public class SkillsController {

    @GetMapping("/")
    public String showRootPage() {
        return "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li> Java </li>" +
                "<li> Javascript </li>" +
                "<li> Python</li>" +
                "</ol>";
    }

    @GetMapping("form")
    public String showBasicForm() {
        return "<form action='response' method='POST'>" +
                createLabel("Name") + "<br />" +
                "<input type='text' name='name' />" + "<br />" +
                createLabel("First Programming Language") + "<br />" +
                createSelectBar("firstLanguage") +  "<br />" +
                createLabel("Second Programming Language") + "<br />" +
                createSelectBar("secondLanguage") + "<br />" +
                createLabel("Third Programming Language") + "<br />" +
                createSelectBar("thirdLanguage") + "<br />" +
                "<input type='submit' value='submit' />" + "<br />" +
                "</form>";
    }

    @PostMapping(value = "response")
    public String showFormResponse(@RequestParam String name, @RequestParam String firstLanguage, @RequestParam String secondLanguage, @RequestParam String thirdLanguage) {
        return
                "<h1>" + name + "</h1>" +
                "<ol>" +
                        "<li> " + firstLanguage + "</li>" +
                        "<li>" + secondLanguage + "</li>" +
                        "<li>" + thirdLanguage + "</li>" +
                "</ol>";
    }

    public String createSelectBar(String name) {
        return "<select name='" + name + "'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Javascript'>Javascript</option>" +
                "<option value='Python'>Python</option>" +
                "</select>";
    }

    public String createLabel(String label) {
        return "<label>" + label + "</label>";
    }

}
