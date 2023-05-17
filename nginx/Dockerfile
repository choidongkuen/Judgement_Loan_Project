FROM nginx:latest
# 직접 만든 default.conf -> 기존 default.conf 대체
COPY default.conf /etc/nginx/conf.d/default.conf
CMD ["nginx", "-g","daemon off;"]



