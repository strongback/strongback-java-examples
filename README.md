[![Build Status](https://travis-ci.org/strongback/strongback-java-examples.svg?branch=master)](https://travis-ci.org/strongback/strongback-java-examples)
# Example Robot Projects

This repository contains a number of sample robot projects that use WPILib and [Strongback](http://strongback.org), and may help you understand how you can use Strongback on your FRC robot.

# Building all projects

This repository is structured similarly to how you might set up your team's repository for a season. You might have a single robot project, or you might have several robot projects. Either way, this repository shows how you can use Ant to locally build all robot projects at once.

This repository contains an Ant build script that will compile all of the robot projects and to run each of their unit tests. For example, after you clone this repository, you can open a terminal, change to local repository's directory, and run the following command:

    $ ant clean test

This will iterate through all robot projects (subdirectories that contain a `build.xml` file), and will run the same Ant tasks on each of those robot projects. This makes it very easy for your team's developers to quickly compile each robot project and run its unit tests. Of course, the script will stop if any of the tasks fail.

# Continuous Integration

We use the [Travis-CI.org](http://travis-ci.org) continuous integration service to monitor our repository and automatically run a build for each pull-request and any time the `master` branch changes. The results of those builds are displayed on the GitHub repository page and on each pull-request page. This makes it easy for your team to know whether your codebase is in a good state. In fact, we always keep our branches buildable and only merge pull-requests that build successfully.

To set up continuous integration on Travis, we first added a `.travis.yml` file that tells Travis about our project and how to build it. Travis already knows about Ant, and it even runs the `ant deps` command before building, giving our build script a chance to download and install any software that's required for the build. This is great, because Travis knows nothing about the WPILib and Strongback libraries, so our Ant script's `deps` task will automatically download both the WPILib and Strongback. The `ant deps` command does nothing if the libraries are found on the machine, so it's actually safe for you to run that command (though there's no reason for you to do so, since to develop FRC robot projects you'll have already installed the WPILib plugins for Eclipse).

# Setting up a repository for your own team

You can reuse this same Ant build script in your own team's repository that contain robot projects that use WPILib and Strongback. To do this, simply copy the `build.xml` and `build.properties` files into the top-level directory of your repository, and then you too can use a single command line to clean, compile, and test all of your robot projects.

You can even set up continuous integration for your team's repository using [Travis-CI.org](http://travis-ci.org). Simply copy our `.travis.yml` into your repository and commit it, and then go to http://travis-ci.org to sign up for an account and set up your CI job.