# Daily Calorie Calculator

A simple clojurescript reagent app to calculate BMR and daily calorie intake using reagent and tailwindcss. Shown in tutorial video [here.](https://youtu.be/oKdE1oMs6Gk)

![App Screenshot](./resources/docs/screenshot.png)

## Installation

This project uses the [Clojure CLI](https://clojure.org/guides/deps_and_cli) as the package manager. [Shadow CLJS](https://shadow-cljs.github.io/docs/UsersGuide.html) and [npm](https://nodejs.org/en) is used as the build tools for the frontend, the clojurescript dependencies are still contained in the deps.edn file.

## Usage

You can run the main function using the `:server` alias and access the http server on port 8080.

```bash
$ clj -M:server
```

To run shadow-cljs use the `npm start` and you can access the frontend app on port 3000
