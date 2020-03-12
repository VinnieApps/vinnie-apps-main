#!/bin/bash

set -e

npx -p mermaid.cli mmdc \
  -i applications/photos/fe_or_be_change_deployment.mermaid \
  -o applications/photos/diagrams/fe_or_be_change_deployment.png
