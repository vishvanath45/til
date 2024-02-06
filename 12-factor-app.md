## What is 12 factor app?

- In current scenariom softwares are developed as Service (SaaS) or web apps, 12 factor app is a methodology to lay down pricinple to guide the development. 

from the top, it looks like

I. Codebase
One codebase tracked in revision control, many deploys

one codebase -> one app



II. Dependencies
Explicitly declare and isolate dependencies

Ensure that dependencies are listed in file and easy to update, for example like Gemfile, project.clj


III. Config
Store config in the environment



IV. Backing services
Treat backing services as attached resources

V. Build, release, run
Strictly separate build and run stages

VI. Processes
Execute the app as one or more stateless processes

VII. Port binding
Export services via port binding

VIII. Concurrency
Scale out via the process model

IX. Disposability
Maximize robustness with fast startup and graceful shutdown

X. Dev/prod parity
Keep development, staging, and production as similar as possible

XI. Logs
Treat logs as event streams

XII. Admin processes
Run admin/management tasks as one-off processes


