#!/bin/bash

set -e

find . -name "*.mermaid" -exec ./scripts/convert_diagram.sh {} \;
