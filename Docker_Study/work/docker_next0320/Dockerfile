FROM node:18
WORKDIR /app

COPY package*.json ./
RUN npm install 

COPY ./ ./              
CMD npm run dev  

# 빌드된 결과들을 /app/out 디렉토리에 복사
# RUN mkdir -p /app/out && cp -r /app/.next/static /app/out/ && cp -r /app/public /app/out/
