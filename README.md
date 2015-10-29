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

You can even set up continuous integration for your team's repository using [Travis-CI.org](http://travis-ci.org). Simply copy our `.travis.yml` into your repository and commit it, and then go to http://travis-ci.org to sign up for an account and set up your CI job. (You can set up Travis for your *private* GitHub repositories, too, although that process is slightly different. See [Travis-CI.org](http://travis-ci.org) for details.)

# Contributing

If you want to help us improve these examples, you can contribute any new robot projects that help showcase Strongback or improve the examples we already have. Just submit pull requests with your proposed changes, and we'll review them and merge them when the changes are acceptable. 

To contribute, you'll first need to fork this repository on GitHub.com, then clone it locally:

    $ git clone git@github.com:<you>/strongback-java-examples.git
    $ cd strongback-java-examples

Add our official repository as an upstream remote, making it easy to fetch and pull changes that we've made to your local repository:

    $ git remote add upstream git@github.com:strongback/strongback-java-examples.git
    $ git branch -u upstream/master

Now you can create a new branch for your improvements, of course using a branch name that makes sense for your changes:

    $ git checkout -b <branch-name>

Then make your changes on that branch and, of course, run a build to make sure that all projects compile and all unit tests pass:

    $ ant clean test

If that build is successful, you can commit your changes:

    $ git add .
    $ git commmit -m "Added another example that ..."

and push this branch to your fork on GitHub:

    $ git push origin <branch-name>

Finally, go to https://github.com/strongback/strongback-java-examples and you should see a green button to create a pull-request from your new branch. Press the button, and fill out the form, using a good description. Meanwhile, Travis will run a build on your pull-request branch, and report success or failure on the pull-request page. Our maintainers are also notified of all pull-requests, so we'll review them and provide any feedback and, when the branch looks good, will merge your changes into the repository.

This process might sounds scary, but it's actually the same process used by most open source projects on GitHub. In fact, you can even use it on your own team's repositories, even when those repositories are private.