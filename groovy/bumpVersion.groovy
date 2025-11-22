#!/usr/bin/env groovy
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

def pkgFile = new File('package.json')
if (!pkgFile.exists()) {
  println "package.json not found!"
  System.exit(1)
}

def pkg = new JsonSlurper().parseText(pkgFile.text)
def version = pkg.version ?: "0.0.0"
def parts = version.tokenize('.').collect { it as int }
if (parts.size() < 3) {
  while (parts.size() < 3) parts << 0
}

parts[2] = parts[2] + 1  // bump patch
def newVersion = "${parts[0]}.${parts[1]}.${parts[2]}"
pkg.version = newVersion
pkgFile.text = JsonOutput.prettyPrint(JsonOutput.toJson(pkg))
println "Bumped version to ${newVersion}"
new File('version.txt').text = newVersion
