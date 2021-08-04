# Nginx作为基础镜像
FROM nginx:latest
RUN mkdir /app
COPY dist /app
COPY nginx.conf /etc/nginx/nginx.conf
