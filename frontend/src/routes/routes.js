import React from 'react';
import { Route } from 'react-router-dom';
import PostForm from '../components/PostForm'; // 경로 확인
import PostList from '../components/PostList'; // 경로 확인

const routes = (
    <>
        <Route path="/" element={<PostList />} />  {/* 기본 경로 */}
        <Route path="/posts/new" element={<PostForm />} />  {/* 게시글 등록 경로 */}
    </>
);

export default routes;