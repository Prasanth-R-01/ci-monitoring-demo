#!/usr/bin/env groovy
import java.nio.file.*

if (args.length < 1) {
  println "Usage: groovy logSummary.groovy <build_log_file>"
  System.exit(1)
}
def logFile = new File(args[0])
if (!logFile.exists()) {
  println "Log file not found: ${args[0]}"
  System.exit(1)
}
def lines = logFile.readLines()
def errorLines = lines.findAll { it =~ /(?i)error/ }
def warnLines = lines.findAll { it =~ /(?i)warn/ }

def summary = new StringBuilder()
summary << "Build Log Summary\n"
summary << "=================\n"
summary << "Total lines: ${lines.size()}\n"
summary << "Errors: ${errorLines.size()}\n"
summary << "Warnings: ${warnLines.size()}\n\n"

if (errorLines) {
  summary << "First 5 error lines:\n"
  errorLines.take(5).each { summary << it + "\n" }
} else {
  summary << "No errors found.\n"
}

if (warnLines) {
  summary << "\nFirst 5 warning lines:\n"
  warnLines.take(5).each { summary << it + "\n" }
}

new File('build_summary.txt').text = summary.toString()
println summary.toString()
