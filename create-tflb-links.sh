#!/bin/sh
# Assumes that the tflb-portal project is in the same dir as this project
rm -rf web-app/css web-app/js web-app/images grails-app/views/index.gsp
ln -s  ../../tflb_portal/dist_bundle/js web-app/js
ln -s  ../../tflb_portal/dist_bundle/css web-app/css
ln -s  ../../../tflb_portal/dist_bundle/index.gsp grails-app/views/
ln -s ../../tflb_portal/dist_bundle/images web-app/images



