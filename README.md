# CI Monitoring Demo (Node.js + Azure Pipelines + Groovy)

Small demo showing:
- Node.js app (Node 18)
- Azure Pipelines CI that runs Groovy automations:
  - version bump (bumpVersion.groovy)
  - build log summary (logSummary.groovy)
- The pipeline sends the build summary to an Azure Log Analytics Workspace (created automatically if missing)
- Artifacts: build_log.txt, build_summary.txt, version.txt

## Files
- `src/index.js` — demo app
- `groovy/bumpVersion.groovy`
- `groovy/logSummary.groovy`
- `scripts/send_to_log_analytics.sh`
- `.pipelines/azure-pipelines.yml`
