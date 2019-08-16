# Selenium BDD
Maven project for a Modular BDD Framework for Selenium with TestNG and Extent Reports

## Design
This framework is divided into multiple layers of abstraction, loosely refered to as modules:
  - Automation
  - Pages
  - Scripts
  - Generators
  - FileIO

## Workflow Description
  - Automation layer has the codes for browser automation (here Selenium).
  - Pages layer has the codes for Page Object which in turn uses the functionalities provided by Automation layer
  - Scripts layer uses methods defined in Pages written in TestNG formats (annotated methods)
  
  (to be updated..)
