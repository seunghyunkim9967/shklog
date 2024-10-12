import React, { useState } from 'react';

const LoginPage = () => {
  // 상태 관리: 이메일과 비밀번호
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  // 로그인 버튼 클릭 시 처리할 함수
  const handleLogin = (e) => {
    e.preventDefault();
    // 로그인 처리 로직 추가 (API 요청 등)
    console.log('로그인 시도:', { email, password });
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
      </form>
      <button onClick={handleSignup} style={styles.signupButton}>
        회원가입
      </button>
    </div>
  );
};

// 간단한 CSS 스타일
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
