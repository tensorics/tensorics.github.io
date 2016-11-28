require 'rake-jekyll'

sh 'git config --local user.email "tensorics-dev@cern.ch"'
sh 'git config --local user.name "tensorics-dev"'
# This task builds the Jekyll site and deploys it to a remote Git repository.
# It's preconfigured to be used with GitHub and Travis CI.
# See http://github.com/jirutka/rake-jekyll for more options.
Rake::Jekyll::GitDeployTask.new(:deploy) 
