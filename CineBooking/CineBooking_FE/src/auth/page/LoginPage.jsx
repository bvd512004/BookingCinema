import { Button, Form } from 'react-bootstrap'
import './LoginPage.css'

function LoginPage() {
  return (
    <section className="login-page">
      <div className="login-card">
        <div className="login-card__side login-card__image">
          <div className="login-card__image-overlay" />
          <div className="login-card__image-content">
            <h1>Find your next perfect stay</h1>
            <p>
              Join millions of travelers discovering unique homes and experiences
              around the world.
            </p>
          </div>
        </div>

        <div className="login-card__side login-card__form">
          <div className="auth-tabs">
            <button type="button" className="auth-tab auth-tab--active">
              Log In
            </button>
            <button type="button" className="auth-tab">Sign Up</button>
          </div>

          <div className="auth-header">
            <h1>Welcome back</h1>
            <p>Please enter your details to sign in.</p>
          </div>

          <Form className="auth-form">
            <Form.Group className="mb-4" controlId="loginEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control type="email" placeholder="Enter your email" />
            </Form.Group>

            <Form.Group className="mb-4" controlId="loginPassword">
              <div className="auth-password-header">
                <Form.Label>Password</Form.Label>
                <a href="#" className="auth-link">
                  Forgot Password?
                </a>
              </div>
              <Form.Control type="password" placeholder="Enter your password" />
            </Form.Group>

            <Button className="btn btn-primary w-100 auth-submit-btn" type="submit">
              Continue
            </Button>
          </Form>

          <div className="auth-divider">Or continue with</div>

          <div className="auth-social-row">
            <Button className="btn btn-outline-secondary auth-social-btn" type="button">
              <span className="social-icon">G</span> Google
            </Button>
            <Button className="btn btn-outline-secondary auth-social-btn" type="button">
              <span className="social-icon">f</span> Facebook
            </Button>
          </div>

          <p className="auth-footer">
            Don't have an account? <a href="#">Sign up</a>
          </p>
        </div>
      </div>
    </section>
  )
}

export default LoginPage
