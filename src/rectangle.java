<?xml version="1.0"?>
<project name="Rectangle-Build" default="main" basedir=".">
  <property environment="env"/>

  <!-- Sets variables which can later be used. -->
  <!-- The value of a property is accessed via ${} -->
  <property name="src.dir" location="src" />
  <property name="build.dir" location="bin" />
  <property name="dist.dir" location="dist" />

  <path id="class.path">
    <pathelement location="./lib/junit-4.10.jar" />
    <pathelement location="${build.dir}" />
  </path>

  <!-- Deletes the existing build, docs and dist directory-->
  <target name="clean">
    <delete dir="${build.dir}" />
    <delete dir="${dist.dir}" />
  </target>

  <!-- Creates the  build, docs and dist directory-->
  <target name="makedir">
    <mkdir dir="${build.dir}" />
    <mkdir dir="${dist.dir}" />
  </target>

  <!-- Compiles the java code (including the usage of library for JUnit -->
  <target name="compile" depends="clean, makedir">
    <javac srcdir="${src.dir}" destdir="${build.dir}">
      <classpath refid="class.path" />
    </javac>
  </target>

  <!--Creates the deployable jar file  -->
  <target name="jar" depends="compile">
    <jar destfile="${dist.dir}\rectangle_${env.MAJOR_VERSION}.${env.BUILD_NUMBER}.jar" basedir="${build.dir}">
      <manifest>
        <attribute name="Main-Class" value="Rectangulator" />
      </manifest>
    </jar>
  </target>

  <target name="main" depends="compile, jar">
    <description>Main target</description>
  </target>

</project>
