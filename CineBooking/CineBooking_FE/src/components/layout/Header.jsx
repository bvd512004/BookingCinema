import { Button, Container, Nav, Navbar } from 'react-bootstrap'

function Header() {
  return (
    <Navbar expand="lg" className="header py-0">
      <Container className="header-inner">
        <Navbar.Brand href="/" className="brand">
          <span className="brand-icon">⌘</span>
          <span className="brand-name">CineBooking</span>
        </Navbar.Brand>

        <Navbar.Toggle aria-controls="home-navbar" />
        <Navbar.Collapse id="home-navbar">
          <Nav className="nav">
            <Nav.Link href="#lich-chieu">Lịch chiếu</Nav.Link>
            <Nav.Link href="#dang-chieu">Phim</Nav.Link>
            <Nav.Link href="#rap">Rạp</Nav.Link>
            <Nav.Link href="#uu-dai">Khuyến mãi</Nav.Link>
            <Nav.Link href="#ho-tro">Hỗ trợ</Nav.Link>
          </Nav>

          <div className="header-search">
            <span className="header-search-icon">⌕</span>
            <input placeholder="Tìm phim, diễn viên..." />
          </div>

          <div className="header-actions">
            <Button className="header-register-btn">Đăng ký</Button>
            <Button className="btn btn-primary header-login-btn">Đăng nhập</Button>
          </div>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  )
}

export default Header
