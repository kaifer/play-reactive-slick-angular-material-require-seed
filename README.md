# Example application for Play+AngularJS+Material+RequireJS.

## Intro

This template application shows how to organize your application with
[Playframework](http://www.playframework.com), [WebJars](http://www.webjars.org),
[RequireJS](http://www.requirejs.org), [AngularJS](http://www.angularjs.org),
and [Angular Material](https://material.angularjs.org)

It adds angular material to play-angular-require-seed.
[Play-Angular-Require-Seed](https://github.com/mariussoutier/play-angular-require-seed).

## Used Versions

* Play Framework: 2.4.0-RC1
* RequireJS: 2.1.17
* AngularJS: 1.3.15
* Angular Material: 0.9.0-rc2
* Play-Slick: 1.0.0

## Code Organization

The JavaScript modules are organized as follows:

    |- app
    |-- assets
    |--- javascripts    <- contains all the JavaScript/CoffeeScript modules
    |---- app.js        <- app module, wires everything together
    |---- main.js       <- tells RequireJS how to load modules and bootstraps the app
    |---- common/       <- a module, in this case
    |----- main.js      <- main file of the module, loads all sub-files in this folder
    |----- filters.js   <- common's filters
    |----- directives/  <- common's directives
    |----- services/    <- common's services
    |---- ...
