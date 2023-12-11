# petervlk/greeter

This repository contains `Hello, World!` application meant to be used as a example/study material
for https://github.com/weavejester/integrant setup and usage.

## Installation

Download from https://github.com/petervlk/greeter

## Usage

Run the project directly, via `:main-opts` (`-m greeter.core`):

    $ clojure -M:run

Visit URL http://localhost:9010/

## TODO

- [x] add integrant/repl to improve repl wowrkflow
- [x] modify config values for development purposes
- [x] move integrant config from `greeter.core` ns to config.edn file
- [x] use https://github.com/juxt/aero to read config.edn including env vars
- [ ] test individual system/integrant components
