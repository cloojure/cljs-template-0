# fred

A complete, working sample project to demonstrate working code with external JavaScript dependency

## Overview

Say you have a JavaScript library you need to include in a ClojureScript project.  We have an
example file `dino.js` we wish to depend on.  The file `dino-externs.js` shows how to tell the
Google Closure compiler about the dependency. The `project.clj` file shows the right syntax to make
everything work as it should.

## Setup

Project was created using `lein new figwheel`

npm install phantomjs
npm install karma karma-cljs-test  --save-dev  
npm install karma-chrome-launcher  karma-firefox-launcher  karma-safari-launcher  --save-dev

To get an interactive development environment run:

  lein clean ; lein figwheel

A browser window will open. Go to the developer console to view results.

To clean all compiled files:

  lein clean

To run Doo tests:

  lein clean ; lein doo phantom test once   # run the tests once and exit
  lein clean ; lein doo phantom test        # rerun the tests after every file edit

## TODO

 - Add reagent stuff
 - Add reframe stuff

## License

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.

