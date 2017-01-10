#/bin/bash

function clear_dir {
  dir=$1
  if [ -d "$dir" ]; then
    rm -rf $dir
  fi
  mkdir $dir
}

base_dir=$(pwd)
working_dir=$base_dir'/related-projects-tmp'
projects_dst=$base_dir'/projects'

core_tmp_dir=$working_dir'/tensorics-core'
core_dst=$projects_dst'/tensorics-core'
core_javadoc_dst=$projects_dst'/tensorics-core'

expression_tmp_dir=$working_dir'/tensorics-expression'
expression_dst=$projects_dst'/tensorics-expression'
expression_javadoc_dst=$projects_dst'/tensorics-expression'

clear_dir $projects_dst
clear_dir $working_dir
clear_dir $core_dst
clear_dir $expression_dst
mkdir $core_javadoc_dst
mkdir $expression_javadoc_dst

echo "Cloning repos"
git clone https://github.com/tensorics/tensorics-core.git $core_tmp_dir
git clone https://github.com/tensorics/tensorics-expression.git $expression_tmp_dir

echo "Generating javadoc"
cd $expression_tmp_dir
./gradlew javadoc
cd $core_tmp_dir
./gradlew javadoc
cd $base_dir

echo "Copying sources"
cp -r $core_tmp_dir'/src' $core_dst
cp -r $expression_tmp_dir'/src' $expression_dst

echo "Copying javadoc"
cp -r $core_tmp_dir'/build/docs/javadoc' $core_javadoc_dst
cp -r $expression_tmp_dir'/build/docs/javadoc' $expression_javadoc_dst

echo "Cleaning"
rm -rf $working_dir
