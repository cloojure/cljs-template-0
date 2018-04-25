# fred

A complete, working sample project to demonstrate working code with external JavaScript dependency

## Overview

Say you have a JavaScript library you need to include in a ClojureScript project.  We have an
example file `dino.js` we wish to depend on.  The file `dino-externs.js` shows how to tell the
Google Closure compiler about the dependency. The `project.clj` file shows the right syntax to make
everything work as it should.

## Setup

Project was created using `lein new figwheel`

Prior to running, you must install NodeJS dependencies:

  ./npm-install.bash    # => downloads npm modules (saved in `./node_modules` dir)

To get an interactive development environment run:

  lein clean ; lein figwheel

A browser window will open. Go to the developer console to view results.

To clean all compiled files:

  lein clean    # very important if build crashes & corrupt output files remain

To run Doo tests:

  lein doo  phantom  test once    # run the tests once and exit (note: not `phantomjs`)
  lein doo  phantom  test         # rerun the tests after every file edit
  lein doo  chrome   test         # can also test using Chrome browser

You can also test in the Chrome browser:
  
  lein clean ; lein doo chrome  test once
  
## TODO

 - Add reagent stuff
 - Add reframe stuff

## License

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
