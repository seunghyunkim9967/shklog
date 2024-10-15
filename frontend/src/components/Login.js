import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {
  // 상태 관리: 이메일과 비밀번호
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate(); // useNavigate 훅 사용

  // 로그인 버튼 클릭 시 처리할 함수
  const handleLogin = async (e) => {
      e.preventDefault();
      setError('');
      console.log('로그인 시도:', { email, password });

      try {
          const response = await axios.post('http://localhost:8080/signin', {
              email,
              password,
          });
          console.log('Login successful:', response.data);
          // 로그인 성공 후 처리
          alert('로그인 성공')
          navigate('/main'); // '/main' 경로로 리다이렉션
      } catch (err) {
          setError('로그인 실패. 다시 시도하세요.');
          console.error('Login error:', err.message);
      }
  };

  // 회원가입 버튼 클릭 시 처리할 함수
  const handleSignup = () => {
    window.location.href = '/signup'; // 회원가입 페이지로 이동
  };

  return (
    <div style={styles.container}>
      <h2>로그인</h2>
      <form onSubmit={handleLogin} style={styles.form}>
        <div style={styles.inputGroup}>
          <label htmlFor="email">이메일</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            style={styles.input}
          />
        </div>
        <div style={styles.inputGroup}>
          <label htmlFor="password">비밀번호</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            style={styles.input}
          />
        </div>
        <button type="submit" style={styles.button}>
          로그인
        </button>
        {error && <div style={{ color: 'red' }}>{error}</div>} {/* 에러 메시지 출력 */}
      </form>
      <button onClick={handleSignup} style={styles.signupButton}>
        회원가입
      </button>
    </div>
  );
};

// CSS 스타일
const styles = {
  container: {
    maxWidth: '400px',
    margin: '100px auto',
    padding: '20px',
    textAlign: 'center',
    border: '1px solid #ddd',
    borderRadius: '10px',
  },
  form: {
    display: 'flex',
    flexDirection: 'column',
  },
  inputGroup: {
    marginBottom: '15px',
  },
  input: {
    padding: '10px',
    fontSize: '16px',
    width: '100%',
    borderRadius: '5px',
    border: '1px solid #ddd',
  },
  button: {
    padding: '10px 20px',
    fontSize: '16px',
    backgroundColor: '#28a745',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
  },
  signupButton: {
    marginTop: '10px',
    padding: '10px 20px',
    fontSize: '16px',
    backgroundColor: '#007bff',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
  },
};

export default LoginPage;
